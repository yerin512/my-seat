package com.codesoom.myseat.controllers.admin.reservations;

import com.codesoom.myseat.domain.Reservation;
import com.codesoom.myseat.dto.ReservationListPageResponse;
import com.codesoom.myseat.services.reservations.ReservationListService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 예약 목록 조회 컨트롤러
 */
@CrossOrigin
@RequestMapping("/admin/reservations")
@RestController
public class AdminReservationListController {
    private final ReservationListService service;

    public AdminReservationListController(ReservationListService service) {
        this.service = service;
    }

    /**
     * 모든 회원의 예약 목록을 조회합니다.
     *
     * @return 모든 예약 정보
     */
    @PreAuthorize("isAuthenticated() and hasAuthority('ADMIN')")
    @GetMapping
    public ReservationListPageResponse reservations(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<Reservation> pageReservation =
                service.allReservations(pageRequest);
        return new ReservationListPageResponse(pageReservation);
    }
}
