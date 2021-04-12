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

import java.util.concurrent.ExecutorService;

/**
 * 调度器，指定一个线程池，负责实际处理actor逻辑
 */
@Data
class Dispatcher {

    /**
     * 调度器id
     */
    private final String dispatcherId;

    /**
     * 线程池
     */
    private final ExecutorService executor;

}
