package com.github.mvp4g.nalu.react.processor.eventbus.eventBusNotExtendingIsEventBus;

import com.github.mvp4g.mvp4g2.core.eventbus.annotation.EventBus;
import com.github.mvp4g.nalu.react.processor.mock.MockShellPresenter;

@EventBus(shell = MockShellPresenter.class)
public interface EventBusNotExtendingIsEventBus {
}
