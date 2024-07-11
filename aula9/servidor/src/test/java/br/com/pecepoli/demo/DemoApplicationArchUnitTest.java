package br.com.pecepoli.demo;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class DemoApplicationArchUnitTest {
    @Test
    public void ensureLayerDependencies() {
        Architectures.LayeredArchitecture arch = layeredArchitecture().consideringAllDependencies()
                .layer("Controller").definedBy("..controller..")
                .layer("Service").definedBy("..service..")
                .layer("Persistence").definedBy("..repository..")
                // Add constraints
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Service")
                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");

        JavaClasses jc = new ClassFileImporter()
                .importPackages("br.com.pecepoli.demo");

        arch.check(jc);
    }
}
