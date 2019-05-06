package bean;

import java.util.List;

public class PageBean<T> {
    // 定义为泛型集合

    private int pc; // 当前页的页码，从页面请求传来的参数
    private int ps; // 当前页显示记录数，自己定义每页显示几条记录
    private int all; // 数据库总记录数，查询数据库

    private String url; // 页面路径
    private List<T> beanList;// 分页数据集合

    /**
     * 获取分页总页数 总记录数除以每页记录数存在余数则页数为maxNum+1 能够整除则总页数即maxNum
     *
     * @return
     */
    public int getMaxPageNum() {
        int maxNum = all / ps;
        return all % ps == 0 ? maxNum : maxNum + 1;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
