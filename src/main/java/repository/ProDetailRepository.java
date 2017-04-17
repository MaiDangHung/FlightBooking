
package repository;

import entity.ProDetailEntity;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProDetailRepository extends CrudRepository<ProDetailEntity, Integer>{
    
}
