package Repository;

import Repository.AbstractIntegrationDBTest;
import Repository.SugerenciaRepository;

import static org.junit.jupiter.api.Assertions.*;

class SugerenciaRepositoryTest extends AbstractIntegrationDBTest {
    SugerenciaRepository sugerenciaRepository;

    public SugerenciaRepositoryTest(SugerenciaRepository sugerenciaRepository) {
        this.sugerenciaRepository = sugerenciaRepository;
    }
}