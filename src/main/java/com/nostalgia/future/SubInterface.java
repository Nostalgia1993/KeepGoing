package com.nostalgia.future;

import java.util.List;

/**
 * @author liunian
 * @createTime 2019/9/26
 * @description
 */
public interface SubInterface extends TestInterface{

    <T> List<T> run();

}
