package ro.andreistoian.SpringNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.andreistoian.SpringNotes.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
}
