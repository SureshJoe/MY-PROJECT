package com.niitproject.DAO;

import java.util.List;

import com.niitproject.Sections.Cart;

public interface CartDAO {
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public List<Cart> getCartList(String username);
    public Cart getCart(int cartId);
}
