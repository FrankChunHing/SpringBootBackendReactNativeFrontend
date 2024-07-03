package powercoders.javaproject.javabackendserver.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powercoders.javaproject.javabackendserver.Modal.User;

import java.util.Optional;

@Repository // interaction to database only
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
}

//import java.util.List;

//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.*;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//@RepositoryRestResource(collectionResourceRel = "user", path = "user")
//public interface UserRepository extends PagingAndSortingRepository<User, Long>, CrudRepository<User, Long>{
//
//}