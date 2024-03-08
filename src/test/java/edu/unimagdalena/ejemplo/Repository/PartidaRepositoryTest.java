package Repository;

import Repository.AbstractIntegrationDBTest;
import Repository.PartidaRepository;

import static org.junit.jupiter.api.Assertions.*;

class PartidaRepositoryTest extends AbstractIntegrationDBTest {
    PartidaRepository partidaRepository;

    public PartidaRepositoryTest(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }
}