package org.eternity.script.movie.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = false)
public class JpaInitTest {
    @Test
    @DisplayName("JPA 엔티티 정상적으로 생성되는지 확인")
    public void initializeEntity() {

    }
}

@Entity
@NoArgsConstructor
class MockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
