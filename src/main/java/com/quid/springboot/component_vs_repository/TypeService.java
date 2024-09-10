package com.quid.spring.component_vs_repository;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TypeService {

    private final ComponentType componentType;
    private final RepositoryType repositoryType;
    private final RepositoryJpa repositoryJpa;

    public void proceed() {
        try {
            componentType.proceed();
        } catch (IllegalArgumentException e) {
            System.out.println("ComponentType.proceed() failed with IllegalArgumentException");
        }

        try {
            repositoryType.proceed();
        } catch (InvalidDataAccessApiUsageException e) {
            System.out.println("RepositoryType.proceed() failed with InvalidDataAccessApiUsageException");
        }

        try {
            repositoryJpa.proceed();
        } catch (InvalidDataAccessApiUsageException e) {
            System.out.println("RepositoryJpa.proceed() failed with InvalidDataAccessApiUsageException");
        }
    }
}
