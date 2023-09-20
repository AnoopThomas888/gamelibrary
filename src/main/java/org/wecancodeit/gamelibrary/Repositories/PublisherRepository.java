package org.wecancodeit.gamelibrary.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.gamelibrary.Models.PublisherModel;

public interface PublisherRepository  extends CrudRepository<PublisherModel,Long>{
   PublisherModel findByName(String name);
}
