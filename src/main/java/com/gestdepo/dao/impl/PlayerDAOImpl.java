package com.gestdepo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.gestdepo.dao.FileDAO;
import com.gestdepo.dao.IPlayerDAO;
import com.gestdepo.dao.impl.dummy.PlayerList;
import com.gestdepo.model.ExerciseVO;
import com.gestdepo.model.PlayerVO;
import com.mongodb.WriteResult;

@Component
public class PlayerDAOImpl implements IPlayerDAO {


	@Autowired
	private FileDAO fileDAO;
	
	private MongoOperations mongoOps;
	private static final String PLAYERS_COLLECTION = "Players";
	
	public PlayerDAOImpl(MongoOperations mongoOps) {
		this.mongoOps=mongoOps;
	}
	

	/**
	 * Returns list of players from dummy database.
	 * 
	 * @return list of players
	 */
	public List<PlayerVO> list(Long seasonId, Long teamId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("seassonId").is(seasonId));
		query.addCriteria(Criteria.where("teamId").is(teamId));
		return this.mongoOps.find(query, PlayerVO.class, PLAYERS_COLLECTION);
	}

	/**
	 * Return player object for given id from dummy database. If player is not
	 * found for id, returns null.
	 * 
	 * @param id
	 *            player id
	 * @return player object for given id
	 */
	public PlayerVO get(long id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoOps.findOne(query, PlayerVO.class, PLAYERS_COLLECTION);
	}

	/**
	 * Create new player in dummy database. Updates the id and insert new player
	 * in list.
	 * 
	 * @param player
	 *            Player object
	 * @return player object with updated id
	 */
	public void create(PlayerVO player) {
		this.mongoOps.insert(player, PLAYERS_COLLECTION);
	}

	/**
	 * Delete the player object from dummy database. If player not found for
	 * given id, returns null.
	 * 
	 * @param id
	 *            the player id
	 * @return id of deleted player object
	 */
	public long delete(long id) {
		WriteResult result = null;
		Query query = new Query(Criteria.where("_id").is(id));
		result = this.mongoOps.remove(query, PlayerVO.class, PLAYERS_COLLECTION);
		return result.getN();
	}

	/**
	 * Update the player object for given id in dummy database. If player not
	 * exists, returns null
	 * 
	 * @param id
	 * @param player
	 * @return player object with id
	 */
	public PlayerVO update(PlayerVO player) {
		this.mongoOps.save(player, PLAYERS_COLLECTION);
		return player;
	}
}
