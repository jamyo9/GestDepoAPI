package com.gestdepo.dao.impl.dummy;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gestdepo.dao.IPlayerDAO;
import com.gestdepo.model.PlayerVO;

@Component
public class PlayerDAODummyImpl implements IPlayerDAO {

	// Dummy database. Initialize with some dummy values.

	/**
	 * Returns list of players from dummy database.
	 * 
	 * @return list of players
	 */
	public List<PlayerVO> list(Long seasonId, Long teamId) {
		List<PlayerVO> players = PlayerList.players;
		if (seasonId.longValue() != 0) {
			
		}
		return players;
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

		for (PlayerVO c : PlayerList.players) {
			if (c.getUserId() == id) {
				return c;
			}
		}
		return null;
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
		player.setUserId(PlayerList.players.size() + 1);
		PlayerList.players.add(player);
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

		for (PlayerVO e : PlayerList.players) {
			if (e.getUserId() == id) {
				PlayerList.players.remove(e);
				return id;
			}
		}

		return 0L;
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

		for (PlayerVO e : PlayerList.players) {
			if (e.getUserId() == player.getUserId()) {
				player.setUserId(e.getUserId());
				PlayerList.players.remove(e);
				PlayerList.players.add(player);
				return player;
			}
		}

		return null;
	}
}
