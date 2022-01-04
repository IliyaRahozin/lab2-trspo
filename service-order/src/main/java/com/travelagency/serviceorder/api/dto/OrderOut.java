package com.travelagency.serviceorder.api.dto;
import com.travelagency.serviceorder.repo.model.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderOut {
    private Order someOrder;
    private List<IdentityDto> someUser;
    private List<TripDto> someTrip;

    public OrderOut(Order someOrder, List<IdentityDto> someUser, List<TripDto> someTrip) {
        this.someOrder = someOrder;
        this.someUser = someUser;
        this.someTrip = someTrip;
    }
}
