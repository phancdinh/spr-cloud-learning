package me.example.springgson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class GsonConfiguration implements WebMvcConfigurer {
//
//  @Bean
//  public GsonBuilder gsonBuilder(List<GsonBuilderCustomizer> customizers) {
//
//    GsonBuilder builder = new GsonBuilder();
//    // Enable the spring.gson.* configuration in the configuration file
//    customizers.forEach((c) -> c.customize(builder));
//
//    /**
//     * Custom Gson configuration
//     */
//    builder.registerTypeHierarchyAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
//
//      DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//      @Override
//      public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
//        return new JsonPrimitive(DATE_TIME_FORMATTER.format(src));
//      }
//    });
//
//    builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
//    return builder;
//  }
}
