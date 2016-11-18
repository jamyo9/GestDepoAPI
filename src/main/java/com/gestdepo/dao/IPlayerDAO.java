package com.gestdepo.dao;

import java.util.List;

import com.gestdepo.model.PlayerVO;

public interface IPlayerDAO {

	List<PlayerVO> list(Long seasonId, Long teamId);
	PlayerVO get(long id);
	void create(PlayerVO player);
	long delete(long id);
	PlayerVO update(PlayerVO player);
}
