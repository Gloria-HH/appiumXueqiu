package com.utils;

import com.xueqiu.appium.utils.YamlUtils;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.support.AnnotationConsumer;
import org.junit.platform.commons.util.Preconditions;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.stream.Stream;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@API(status = API.Status.EXPERIMENTAL, since = "5.0")
@ArgumentsSource(YamlFileArgumentsProvider.class)
public @interface YamlFileSource {

    String[] resources();
    Class type();
}

class YamlFileArgumentsProvider<T> implements ArgumentsProvider, AnnotationConsumer<YamlFileSource> {

    private String[] resources;
    private Class<T> type;

    @Override
    @SuppressWarnings("unchecked")
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        if (Object.class.equals(type)) {
            context.getTestMethod().filter(method -> method.getParameterCount() > 0)
                    .map(method -> method.getParameterTypes()[0])
                    .ifPresent(clazz -> type = (Class<T>) clazz);
        }
        return Arrays.stream(resources).map(this::readValue).map(Arguments::of);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void accept(YamlFileSource annotation) {
        resources = annotation.resources();
        type = annotation.type();
    }

    private T readValue(String filePath) {
        Preconditions.notBlank(filePath, "file path is empty");
        try {
            return YamlUtils.readConfigFromYaml(filePath, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
