package kr.hs.entrydsm.rollsroyce.domain.admin.facade;

import kr.hs.entrydsm.rollsroyce.domain.admin.domain.Admin;
import kr.hs.entrydsm.rollsroyce.domain.admin.domain.repository.AdminRepository;
import kr.hs.entrydsm.rollsroyce.domain.admin.domain.types.Role;
import kr.hs.entrydsm.rollsroyce.domain.admin.exception.AdminNotAccessibleException;
import kr.hs.entrydsm.rollsroyce.domain.admin.exception.AdminNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminFacade {

	private final AdminRepository adminRepository;

	public Admin getAdminById(String id) {
		return adminRepository.findById(id)
				.orElseThrow(() -> AdminNotFoundException.EXCEPTION);
	}

	public Admin getRootAdmin(String id) {
		return adminRepository.findById(id)
				.filter(admin -> admin.getRole().equals(Role.ROLE_ROOT))
				.orElseThrow(() -> AdminNotAccessibleException.EXCEPTION);
	}

	public Role getAdminRole(String id) {
		return adminRepository.findById(id)
				.map(Admin::getRole)
				.orElseThrow(() -> AdminNotFoundException.EXCEPTION);
	}

}
