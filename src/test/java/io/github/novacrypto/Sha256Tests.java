/*
 *  SHA-256 library
 *
 *  Copyright (C) 2017-2022 Alan Evans, NovaCrypto
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *  Original source: https://github.com/NovaCrypto/SHA256
 *  You can contact the authors via github issues.
 */

package io.github.novacrypto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static io.github.novacrypto.Asserts.assertByteArraysSame;
import static io.github.novacrypto.Hex.toArray;
import static io.github.novacrypto.hashing.Sha256.sha256;

@RunWith(Parameterized.class)
public final class Sha256Tests {
    private final byte[] input;
    private final byte[] expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"},
                {"00", "6e340b9cffb37a989ca544e6bb780a2c78901d3fb33738768511a30617afa01d"},
                {"01", "4bf5122f344554c53bde2ebb8cd2b7e3d1600ad631c385a5d7cce23c7785459a"},
                {"0000", "96a296d224f285c67bee93c30f8a309157f0daa35dc5b87e410b78630a09cfc7"},
                {"ffff", "ca2fd00fa001190744c15c317643ab092e7048ce086a243e2be9437c898de1bb"}
        });
    }

    public Sha256Tests(String input, String expected) {
        this.input = toArray(input);
        this.expected = toArray(expected);
    }

    @Test
    public void sha256Test() {
        assertByteArraysSame(expected, sha256(input));
    }
}
