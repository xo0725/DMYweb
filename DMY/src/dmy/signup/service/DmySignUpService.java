package dmy.signup.service;

import java.util.List;

import dmy.signup.vo.DmySignUpVO;

public interface DmySignUpService {

	public List<DmySignUpVO> listSignUp(DmySignUpVO svo);
	public List<DmySignUpVO> viewSinUpMatch(DmySignUpVO svo);
	public DmySignUpVO viewSignUp(DmySignUpVO svo);
	public List<DmySignUpVO> signUpCheckMatch(DmySignUpVO svo);
	public int signUpMatch(DmySignUpVO svo);
	public int updateSignUp(DmySignUpVO svo);
	public int deleteSignUp(DmySignUpVO svo);
	public int acceptSignUp(DmySignUpVO svo);
	
}
