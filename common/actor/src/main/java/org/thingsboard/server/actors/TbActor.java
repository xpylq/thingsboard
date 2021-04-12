/**
 * Copyright © 2016-2021 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.actors;

import org.thingsboard.server.common.msg.TbActorMsg;

/**
 * actor核心接口
 */
public interface TbActor {


    /**
     * 处理消息
     */
    boolean process(TbActorMsg msg);

    /**
     * 获取actor引用
     */
    TbActorRef getActorRef();

    /**
     * 初始化actor
     */
    default void init(TbActorCtx ctx) throws TbActorException {
    }

    /**
     * 销毁actor
     */
    default void destroy() throws TbActorException {
    }

    /**
     * 定义actor初始化失败的策略
     */
    default InitFailureStrategy onInitFailure(int attempt, Throwable t) {
        return InitFailureStrategy.retryWithDelay(5000 * attempt);
    }

    /**
     * 定义actor处理消息失败的策略
     */
    default ProcessFailureStrategy onProcessFailure(Throwable t) {
        if (t instanceof Error) {
            return ProcessFailureStrategy.stop();
        } else {
            return ProcessFailureStrategy.resume();
        }
    }
}
