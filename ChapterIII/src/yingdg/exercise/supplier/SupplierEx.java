package yingdg.exercise.supplier;

import com.google.common.base.Objects;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.junit.Test;

/**
 * Created by YingDG on 2017/2/10.
 */
public class SupplierEx implements Supplier<String> {
    @Override
    public String get() {
        return "everything OK!";
    }

    @Test
    public void supplierTest() {
        String s = this.get();
        System.out.println(s);

        /*
        Suppliers.memoize方法返回一个包装了委托实现的Supplier实例。
        当第一调用get方法，会被调用真实的Supplier实例的get方法。
        memoize方法返回被包装后的Supplier实例。
        包装后的Supplier实例会缓存调用返回的结果。
        后面的调用get方法会返回缓存的实例。
         */
        Supplier<String> supplier = Suppliers.memoize(new SupplierEx());
        String s1 = supplier.get();
        System.out.println(Objects.equal(s, s1));
    }
}
