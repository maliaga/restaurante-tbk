package cl.transbank.restaurant.app.service;

import cl.transbank.restaurant.app.service.dto.LoginDTO;


public interface IUserService {
    String login(LoginDTO loginDTO);
}
