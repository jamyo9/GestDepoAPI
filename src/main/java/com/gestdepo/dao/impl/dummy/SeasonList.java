package com.gestdepo.dao.impl.dummy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gestdepo.model.ExerciseVO;
import com.gestdepo.model.SeasonVO;

public class SeasonList {

	static public List<SeasonVO> seasons = new ArrayList<SeasonVO>();
	
	static {
		Map<Date, List<ExerciseVO>> planning = new HashMap<Date, List<ExerciseVO>>();
		planning.put(new Date(), ExerciseList.exercises);
		SeasonVO s = new SeasonVO(1L, "Season 1", new Date(), new Date(), 1L, planning );
		seasons.add(s);
		
		planning = new HashMap<Date, List<ExerciseVO>>();
		planning.put(new Date(), ExerciseList.exercises);
		s = new SeasonVO(2L, "Season 2", new Date(), new Date(), 1L, planning );
		seasons.add(s);
	}
	
}
