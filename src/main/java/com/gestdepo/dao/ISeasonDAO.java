package com.gestdepo.dao;

import java.util.List;

import com.gestdepo.model.SeasonVO;

public interface ISeasonDAO {

	List<SeasonVO> list();

	SeasonVO get(long id);

	SeasonVO create(SeasonVO season);

	long delete(long id);

	SeasonVO update(SeasonVO season);

	SeasonVO getLastSeason();

}
