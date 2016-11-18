package com.gestdepo.dao.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import com.gestdepo.model.PlayerVO;

public class PlayerList {

	static public List<PlayerVO> players = new ArrayList<PlayerVO>();
	
	static {
		PlayerVO s = new PlayerVO(1L, 1L, "test@test.com", "test", "test", "Pepito", "Grillo", "test", null, null);
		players.add(s);
		
		s = new PlayerVO(2L, 1L, "test@test.com", "test", "test", "Pinocho", "", "test", null, null);
		players.add(s);
	}
	
}
