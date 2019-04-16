package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PollRepository extends CrudRepository<Poll, Integer> {

    @Query(value="select * from poll where label is NULL;",nativeQuery = true)
    List<Poll> findPollsWithoutLabel();

}
