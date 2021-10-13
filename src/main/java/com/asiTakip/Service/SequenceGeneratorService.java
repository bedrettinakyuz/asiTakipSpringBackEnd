package com.asiTakip.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.asiTakip.models.UserSequence;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;
@Service
public class SequenceGeneratorService {

	@Autowired
	private MongoOperations mongoOperations;
	
	public int getSequenceNumber(String sequenceName) {
		
		Query query = new Query(Criteria.where("id").is(sequenceName));
		Update update = new Update().inc("seqNo",1);
		UserSequence counter = mongoOperations
				.findAndModify(query, update, options().returnNew(true).upsert(true),
						UserSequence.class);
		return !Objects.isNull(counter) ? counter.getSeqNo() :1;
	}
}
