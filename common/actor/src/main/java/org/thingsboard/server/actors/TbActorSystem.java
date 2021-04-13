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

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Predicate;

/**
 * actor系统核心接口
 */
public interface TbActorSystem {

    ScheduledExecutorService getScheduler();

    void createDispatcher(String dispatcherId, ExecutorService executor);

    void destroyDispatcher(String dispatcherId);

    TbActorRef getActor(TbActorId actorId);

    TbActorRef createRootActor(String dispatcherId, TbActorCreator creator);

    TbActorRef createChildActor(String dispatcherId, TbActorCreator creator, TbActorId parent);

    /**
     * 发送消息到指定actor（普通优先级）
     */
    void tell(TbActorId target, TbActorMsg actorMsg);

    /**
     * 发送消息到指定actor（高优先级）
     */
    void tellWithHighPriority(TbActorId target, TbActorMsg actorMsg);

    /**
     * 根据actorRef，停止该actor
     */
    void stop(TbActorRef actorRef);

    /**
     * 根据actorId，停止该actor
     */
    void stop(TbActorId actorId);

    /**
     * 停止actor system
     * 1. 关闭所有调度器
     * 2. 关闭scheduler
     * 3. 清空所有actor
     */
    void stop();

    /**
     * 发送消息给指定actor的所有子actor（只包含一级子actor）
     */
    void broadcastToChildren(TbActorId parent, TbActorMsg msg);

    /**
     * 发送消息给指定actor的所有符合条件的子actor（只包含一级子actor）
     */
    void broadcastToChildren(TbActorId parent, Predicate<TbActorId> childFilter, TbActorMsg msg);

    /**
     * 根据条件，查询指定actor的所有子actor（只包含一级子actor）
     */
    List<TbActorId> filterChildren(TbActorId parent, Predicate<TbActorId> childFilter);
}
