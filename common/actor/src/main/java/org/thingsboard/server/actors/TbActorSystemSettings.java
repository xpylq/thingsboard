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

import lombok.Data;

/**
 * actor system的全局配置
 */
@Data
public class TbActorSystemSettings {

    /**
     * actor 单次执行处理消息的数量
     */
    private final int actorThroughput;
    /**
     * actor system 调度线程池大小
     */
    private final int schedulerPoolSize;
    /**
     * actor初始化最大尝试次数，默认为0表示不限制
     */
    private final int maxActorInitAttempts;

}
