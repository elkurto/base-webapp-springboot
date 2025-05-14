package a.b.basewebappsb.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private Long createdAt;


    public BookEntity() {

    }

    public BookEntity(UUID id, String name, String author, Long createdAt) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o ) {
        if ( this == o ) {
            return true;
        }else if ( o instanceof BookEntity other) {
            return Objects.equals(this.id, other.id);
        }

        return false;
    }


    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return String.format("BookEntity(%s,%s)", id, name);
    }
}
