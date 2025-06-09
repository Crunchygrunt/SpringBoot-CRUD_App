package com.crudapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crudapi.model.CloudVendor;
import com.crudapi.repository.CloudVendorRepository;
import net.datafaker.Faker;

@Configuration
public class DataSeeder {
    @Bean
CommandLineRunner seedDatabase(CloudVendorRepository repository) {
    return args -> {
        Faker faker = new Faker();

        for (int i = 1; i <= 30; i++) {
            String id = "V" + i;
            if(repository.existsById(id)) continue;
            CloudVendor vendor = new CloudVendor(
                id,
                faker.company().name(),
                faker.address().streetAddress() + ", " + faker.address().city(),
                faker.phoneNumber().cellPhone()
            );
            repository.save(vendor);
        }

        System.out.println("🌱 Seeded 10 fake CloudVendor records.");
    };
}
}
