package service;

import java.util.List;

import dao.RoomDao;
import dao.RoomDaoImpl;
import dto.RoomDto;

public class RoomService implements RoomServiceImpl{

	RoomDaoImpl roomDao = new RoomDao();
	
	@Override
	public RoomDto checkRoom(String user, String target) {
		RoomDto room = roomDao.checkRoom(user, target);
		
		if(room == null) {
			room = roomDao.makeRoom(user, target);
		}
		
		
		return room;
	}
	

    @Override
    public List<RoomDto> getRoomByUesrId(String user_id) {
        return roomDao.getRoomByUesrId(user_id);
    }

}
