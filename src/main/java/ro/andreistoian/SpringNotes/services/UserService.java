package ro.andreistoian.SpringNotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.andreistoian.SpringNotes.dao.UserDAO;
import ro.andreistoian.SpringNotes.models.Note;
import ro.andreistoian.SpringNotes.models.User;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    UserDAO repo;

    public List<User> listAll(){
        return repo.findAll();
    }

    public User getById(Long id) throws NoSuchElementException {
        return repo.findById(id).get();
    }

    public User getByUserName(String username) {
        return repo.findByUsername(username).get();
    }

    public void save(User user) {
        repo.save(user);
    }

    public List<Note> getNotesByUserId(Long id) {
        return repo.findById(id).get().getNotes();
    }

}
