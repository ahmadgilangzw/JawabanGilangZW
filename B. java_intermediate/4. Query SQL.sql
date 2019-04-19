1. Daftar pelanggan yang beralamat di kota Irvine 
- SELECT * FROM m_customers WHERE city = 'Irvine';

2. Daftar semua pelanggan yang pesanannya ditangani karyawan bernama Adam Barr
- SELECT c.* FROM t_orders o 
	JOIN m_customers c ON(o.m_customer_id = c.customer_id)
	JOIN m_employees e ON(o.m_employee_id = e.employee_id)
	WHERE CONCAT(e.first_name ,' ', e.last_name) = 'Adam Barr'
	GROUP BY c.customer_id
	
3. Daftar produk yang dipesan oleh pelanggan Contoso, Ltd  
- SELECT p.* FROM t_orders o
	JOIN t_order_details od ON(od.m_order_id = o.order_id)
	JOIN m_customers c ON(o.m_customer_id = c.customer_id)
	JOIN m_products p ON(od.m_product_id = p.product_id)
	WHERE c.company_name = 'Contoso, Ltd'
	
4. Daftar transaksi pemesanan yang dikirimkan melalui UPS Ground
- SELECT o.* from t_orders o
	JOIN m_shipping_methods s ON(o.m_shipping_method_id = s.shipping_method_id)
	WHERE s.shipping_method = 'UPS Ground'
	
5. Daftar biaya total pemesanan (termasuk pajak dan biaya pengiriman) setiap  transaksi diurut berdasarkan tanggal transaksi
- SELECT o.order_date,
	(SELECT SUM((quantity * unit_price) - (((quantity * unit_price) * discount) / 100)) as sub_total FROM t_order_details WHERE m_order_id = o.order_id),
	o.freight_charge, o.taxes, 
	((SELECT SUM((quantity * unit_price) - (((quantity * unit_price) * discount) / 100)) as subtotal FROM t_order_details WHERE m_order_id = o.order_id) + o.freight_charge + o.taxes) as grand_total
	FROM t_orders o order by o.order_date asc;

