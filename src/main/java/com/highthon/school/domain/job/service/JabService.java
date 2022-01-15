package com.highthon.school.domain.job.service;

import com.highthon.school.domain.interest.Interest;
import com.highthon.school.domain.interest.repository.InterestRepository;
import com.highthon.school.domain.job.Branch;
import com.highthon.school.domain.job.Jab;
import com.highthon.school.domain.job.dto.CreateJabRequestDto;
import com.highthon.school.domain.job.dto.JabInfoResponseDto;
import com.highthon.school.domain.job.repository.JabRepository;
import com.highthon.school.domain.user.facade.UserFacade;
import com.highthon.school.global.exception.JabNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JabService {
    private final JabRepository jabRepository;
    private final InterestRepository interestRepository;
    private final UserFacade userFacade;

    public void createJab(CreateJabRequestDto req){
        jabRepository.save(
                Jab.builder()
                        .name(req.getName())
                        .intro(req.getIntro())
                        .branch(req.getBranch())
                        .build()
        );
    }

    public JabInfoResponseDto getJabDetails(String jabName){
        Jab jab = jabRepository.findById(jabName).orElseThrow(JabNotFoundException::new);
        return JabInfoResponseDto.builder()
                .jab(jab.getName())
                .intro(jab.getIntro())
                .interest(interestCheck(userFacade.getCurrentUser().getId(), jab.getName()))
                .branch(jab.getBranch()).build();
    }

    public List<JabInfoResponseDto> jabList(Branch branch){
        return createJabInfoResponseList(jabRepository.findAllByBranch(branch));
    }

    // 관심 순
    public List<JabInfoResponseDto> mostInterestJabList(Branch branch){
        return createJabInfoResponseList(jabRepository.findAllByBranchOrderByInterestCount(branch));
    }

    public List<JabInfoResponseDto> orderByJabNameList(Branch branch){
        return createJabInfoResponseList(jabRepository.findAllByBranchOrderByName(branch));
    }

    private List<JabInfoResponseDto> createJabInfoResponseList(List<Jab> jabs){
        List<JabInfoResponseDto> res = new ArrayList<>();
        for(Jab jab : jabs){
            res.add(
                    JabInfoResponseDto.builder()
                            .jab(jab.getName())
                            .intro(jab.getIntro())
                            .interest(interestCheck(userFacade.getCurrentUser().getId(), jab.getName()))
                            .branch(jab.getBranch()).build()
            );
        }
        return res;
    }

    private boolean interestCheck(String userId, String jabName){
        Optional<Interest> interest = interestRepository.findByJab_NameAndUser_Id(jabName, userId);
        return interest.isPresent();
    }
}
