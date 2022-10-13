package mx.gob.sat.sicre.utils.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import mx.gob.sat.sicre.utils.dto.LivePage;
import mx.gob.sat.sicre.utils.dto.PageResponse;

public final class PageConverter {

    private PageConverter() {
    }

    public static <T> PageResponse pageToPageResponse(Page<T> page) {
        PageResponse output = new PageResponse();
        output.setNumber(page.getNumber());
        output.setTotalElements(page.getNumberOfElements());
        output.setTotalPages(page.getTotalPages());
        return output;
    }

    public static PageRequest livePageToPageRequest(LivePage page) {
        if (page.getSort() != null) {
            return new PageRequest(page.getCurrentPage(), page.getPageSize(), executeSorts(page));
        } else {
            return new PageRequest(page.getCurrentPage(), page.getPageSize());
        }

    }

    private static Sort executeSorts(LivePage page) {

        List<Order> orders = new ArrayList<>();

        orders.add(new Order(defineDirection(page.getSort().getDirection()), page.getSort().getField()));
        return new Sort(orders);
    }

    private static Direction defineDirection(String direction) {
        Direction directionEnum = Direction.ASC;

        if (direction.equalsIgnoreCase("DESC")) {
            directionEnum = Direction.DESC;
        }

        return directionEnum;
    }

}
