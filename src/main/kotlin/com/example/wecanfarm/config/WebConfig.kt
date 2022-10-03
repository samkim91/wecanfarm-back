package com.example.wecanfarm.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000", "https://we-can-farm.vercel.app/")
            .allowCredentials(true)
            .allowedMethods(HttpMethod.GET.name, HttpMethod.POST.name, HttpMethod.PATCH.name, HttpMethod.PUT.name, HttpMethod.DELETE.name)
            .maxAge(3600)

    }
}