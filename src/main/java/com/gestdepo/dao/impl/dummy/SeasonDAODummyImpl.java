package com.gestdepo.dao.impl.dummy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gestdepo.dao.ISeasonDAO;
import com.gestdepo.model.SeasonVO;

@Component
public class SeasonDAODummyImpl implements ISeasonDAO {

	// Dummy database. Initialize with some dummy values.

	/**
	 * Returns list of seasons from dummy database.
	 * 
	 * @return list of seasons
	 */
	public List<SeasonVO> list() {
		return SeasonList.seasons;
	}

	/**
	 * Return season object for given id from dummy database. If season is not
	 * found for id, returns null.
	 * 
	 * @param id
	 *            season id
	 * @return season object for given id
	 */
	public SeasonVO get(long id) {

		for (SeasonVO c : SeasonList.seasons) {
			if (c.getSeasonId() == id) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Create new season in dummy database. Updates the id and insert new season
	 * in list.
	 * 
	 * @param season
	 *            Season object
	 * @return season object with updated id
	 */
	public SeasonVO create(SeasonVO season) {
		season.setSeasonId(SeasonList.seasons.size() + 1);
		SeasonList.seasons.add(season);
		return season;
	}

	/**
	 * Delete the season object from dummy database. If season not found for
	 * given id, returns null.
	 * 
	 * @param id
	 *            the season id
	 * @return id of deleted season object
	 */
	public long delete(long id) {

		for (SeasonVO e : SeasonList.seasons) {
			if (e.getSeasonId() == id) {
				SeasonList.seasons.remove(e);
				return id;
			}
		}

		return 0L;
	}

	/**
	 * Update the season object for given id in dummy database. If season not
	 * exists, returns null
	 * 
	 * @param id
	 * @param season
	 * @return season object with id
	 */
	public SeasonVO update(SeasonVO season) {

		for (SeasonVO e : SeasonList.seasons) {
			if (e.getSeasonId() == season.getSeasonId()) {
				season.setSeasonId(e.getSeasonId());
				SeasonList.seasons.remove(e);
				SeasonList.seasons.add(season);
				return season;
			}
		}

		return null;
	}

	@Override
	public SeasonVO getLastSeason() {
		Collections.sort(SeasonList.seasons, new Comparator<SeasonVO>() {
			public int compare(SeasonVO s1, SeasonVO s2) {
				return s1.getStartDate().compareTo(s2.getStartDate());
			}
		});
		return SeasonList.seasons.get(0);
	}
}
