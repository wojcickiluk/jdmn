/*
 * Copyright 2016 Goldman Sachs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.gs.dmn.feel.lib.type.time.xml;

import com.gs.dmn.feel.lib.type.bool.BooleanType;
import com.gs.dmn.feel.lib.type.bool.DefaultBooleanType;
import com.gs.dmn.feel.lib.type.time.DateTimeType;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

import static com.gs.dmn.feel.lib.type.time.xml.DefaultTimeType.hasTimezone;

public class DefaultDateTimeType extends XMLCalendarType implements DateTimeType<XMLGregorianCalendar, Duration> {
    private final DefaultXMLCalendarComparator comparator;
    private final BooleanType booleanType;

    public DefaultDateTimeType() {
        this(new DefaultXMLCalendarComparator());
    }

    public DefaultDateTimeType(DefaultXMLCalendarComparator comparator) {
        this.comparator = comparator;
        this.booleanType = new DefaultBooleanType();
    }

    //
    // Date and time operators
    //

    @Override
    public Boolean dateTimeIs(XMLGregorianCalendar first, XMLGregorianCalendar second) {
        if (first == null || second == null) {
            return first == second;
        }

        return ((FEELXMLGregorianCalendar) first).same(second);
    }

    @Override
    public Boolean dateTimeEqual(XMLGregorianCalendar first, XMLGregorianCalendar second) {
        return this.comparator.equalTo(first, second);
    }

    @Override
    public Boolean dateTimeNotEqual(XMLGregorianCalendar first, XMLGregorianCalendar second) {
        return this.booleanType.booleanNot(dateTimeEqual(first, second));
    }

    @Override
    public Boolean dateTimeLessThan(XMLGregorianCalendar first, XMLGregorianCalendar second) {
        return this.comparator.lessThan(first, second);
    }

    @Override
    public Boolean dateTimeGreaterThan(XMLGregorianCalendar first, XMLGregorianCalendar second) {
        return this.comparator.greaterThan(first, second);
    }

    @Override
    public Boolean dateTimeLessEqualThan(XMLGregorianCalendar first, XMLGregorianCalendar second) {
        return this.comparator.lessEqualThan(first, second);
    }

    @Override
    public Boolean dateTimeGreaterEqualThan(XMLGregorianCalendar first, XMLGregorianCalendar second) {
        return this.comparator.greaterEqualThan(first, second);
    }

    @Override
    public Duration dateTimeSubtract(XMLGregorianCalendar first, XMLGregorianCalendar second) {
        if (first == null || second == null) {
            return null;
        }
        if (isDate(first)) {
            first = dateToDateTime(first);
        }
        if (isDate(second)) {
            second = dateToDateTime(second);
        }
        if (
                hasTimezone(first) && !hasTimezone(second)
                || !hasTimezone(first) && hasTimezone(second)) {
            return null;
        }

        long durationInSeconds = getDurationInSeconds(first, second);
        return XMLDurationFactory.INSTANCE.fromSeconds(durationInSeconds);
    }

    @Override
    public XMLGregorianCalendar dateTimeAddDuration(XMLGregorianCalendar dateTime, Duration duration) {
        if (dateTime == null || duration == null) {
            return null;
        }

        XMLGregorianCalendar clone = (XMLGregorianCalendar) dateTime.clone();
        clone.add(duration);
        return clone;
    }

    @Override
    public XMLGregorianCalendar dateTimeSubtractDuration(XMLGregorianCalendar dateTime, Duration duration) {
        if (dateTime == null || duration == null) {
            return null;
        }

        return dateTimeAddDuration(dateTime, duration.negate());
    }
}
