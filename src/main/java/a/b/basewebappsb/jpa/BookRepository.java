package a.b.basewebappsb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {
}
