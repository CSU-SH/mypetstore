package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.LineItem;

import java.util.List;

public interface LineItemDAO {

    List<LineItem> getLineItemsByOrderId(int orderId) throws Exception;

    void insertLineItem(LineItem lineItem) throws Exception;
}
