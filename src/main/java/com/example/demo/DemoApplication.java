package com.example.demo;

import javax.sql.DataSource;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.server.JobActivator;
import org.jobrunr.storage.InMemoryStorageProvider;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.sql.common.SqlStorageProviderFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// @Bean
    // public StorageProvider storageProvider(JobMapper jobMapper) {
    //     InMemoryStorageProvider storageProvider = new InMemoryStorageProvider();
    //     storageProvider.setJobMapper(jobMapper);
    //     return storageProvider;
    // }

	@Bean
    public JobScheduler initJobRunr(DataSource dataSource, JobActivator jobActivator) {
        return JobRunr.configure()
                .useStorageProvider(SqlStorageProviderFactory
                          .using(dataSource))
                .useJobActivator(jobActivator)
                .useDefaultBackgroundJobServer()
				.useDashboard()
                .initialize();
    }

}
