package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;

	/**
	 * �������ע��
	 * 1.propagation ����Ĵ�����Ϊ����ǰ������һ���������ʱ��
	 * ���ʹ������Ĭ��ȡֵ��REQUIRED��ʹ�õ��÷���������
	 * REQUIRED_NEW:ʹ���Լ������񣬵��÷��������񱻹���
	 * 2.isolation ָ������ĸ��뼶����õ�ȡֵ��READ_COMMITTED
	 * 3.Ĭ������� Spring ������ʽ��������е�����ʱ�쳣���лع�. Ҳ����ͨ����Ӧ��
	 *   ���Խ�������. ͨ�������ȥĬ��ֵ����.
	 * 4.ʹ��readOnlyָ�������Ƿ�Ϊֻ����ֻ����ʾ��ȡ���ݵ�����������
	 * �������԰������ݿ������Ż�����. �������һ��ֻ��ȡ���ݿ�ֵ�ķ���,
	 * Ӧ���� readOnly = true.
	 * 5.ʹ��timeoutָ��ǿ�ƻع�֮ǰ�������ռ�õ�ʱ��
	 *
	 * @param username
	 * @param isbn
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW,
					isolation = Isolation.READ_COMMITTED,
					readOnly = false,
					timeout = 3)
	public void purchase(String username, String isbn) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
		//1. ��ȡ��ĵ���
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		//2. �������Ŀ��
		bookShopDao.updateBookStock(isbn);
		
		//3. �����û����
		bookShopDao.updateUserAccount(username, price);
	}

}
