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
	 * 添加事务注解
	 * 1.propagation 事务的传播行为，当前事务被另一个事务调用时，
	 * 如何使用事务，默认取值：REQUIRED，使用调用方法的事务。
	 * REQUIRED_NEW:使用自己的事务，调用方法的事务被挂起。
	 * 2.isolation 指定事务的隔离级别，最常用的取值，READ_COMMITTED
	 * 3.默认情况下 Spring 的声明式事务对所有的运行时异常进行回滚. 也可以通过对应的
	 *   属性进行设置. 通常情况下去默认值即可.
	 * 4.使用readOnly指定事务是否为只读，只读表示读取数据但不更新数据
	 * 这样可以帮助数据库引擎优化事务. 若真的事一个只读取数据库值的方法,
	 * 应设置 readOnly = true.
	 * 5.使用timeout指定强制回滚之前事务可以占用的时间
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
		
		//1. 获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		//2. 更新数的库存
		bookShopDao.updateBookStock(isbn);
		
		//3. 更新用户余额
		bookShopDao.updateUserAccount(username, price);
	}

}
