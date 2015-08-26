package com.github.dockerjava.core.command;

import static com.google.common.base.Preconditions.checkNotNull;

import com.github.dockerjava.api.command.LogContainerCmd;
import com.github.dockerjava.api.model.Frame;

/**
 * Get container logs
 *
 * @param followStream
 *            - true or false, return stream. Defaults to false.
 * @param stdout
 *            - true or false, includes stdout log. Defaults to false.
 * @param stderr
 *            - true or false, includes stderr log. Defaults to false.
 * @param timestamps
 *            - true or false, if true, print timestamps for every log line. Defaults to false.
 * @param tail
 *            - `all` or `<number>`, Output specified number of lines at the end of logs
 */
public class LogContainerCmdImpl extends AbstrAsyncDockerCmd<LogContainerCmd, Frame> implements LogContainerCmd {

    private String containerId;

    private Integer tail;

    private Boolean followStream, timestamps, stdout, stderr;

    public LogContainerCmdImpl(LogContainerCmd.Exec exec, String containerId) {
        super(exec);
        withContainerId(containerId);
    }

    @Override
    public String getContainerId() {
        return containerId;
    }

    @Override
    public Integer getTail() {
        return tail;
    }

    @Override
    public Boolean hasFollowStreamEnabled() {
        return followStream;
    }

    @Override
    public Boolean hasTimestampsEnabled() {
        return timestamps;
    }

    @Override
    public Boolean hasStdoutEnabled() {
        return stdout;
    }

    @Override
    public Boolean hasStderrEnabled() {
        return stderr;
    }

    @Override
    public LogContainerCmd withContainerId(String containerId) {
        checkNotNull(containerId, "containerId was not specified");
        this.containerId = containerId;
        return this;
    }

    @Override
    public LogContainerCmd withFollowStream() {
        return withFollowStream(true);
    }

    @Override
    public LogContainerCmd withFollowStream(Boolean followStream) {
        this.followStream = followStream;
        return this;
    }

    @Override
    public LogContainerCmd withTimestamps() {
        return withTimestamps(true);
    }

    @Override
    public LogContainerCmd withTimestamps(Boolean timestamps) {
        this.timestamps = timestamps;
        return this;
    }

    @Override
    public LogContainerCmd withStdOut() {
        return withStdOut(true);
    }

    @Override
    public LogContainerCmd withStdOut(Boolean stdout) {
        this.stdout = stdout;
        return this;
    }

    @Override
    public LogContainerCmd withStdErr() {
        return withStdErr(true);
    }

    @Override
    public LogContainerCmd withStdErr(Boolean stderr) {
        this.stderr = stderr;
        return this;
    }

    @Override
    public LogContainerCmd withTailAll() {
        this.tail = -1;
        return this;
    }

    @Override
    public LogContainerCmd withTail(Integer tail) {
        this.tail = tail;
        return this;
    }

}
