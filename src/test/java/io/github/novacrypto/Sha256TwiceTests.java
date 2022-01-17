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
import static io.github.novacrypto.hashing.Sha256.sha256Twice;

@RunWith(Parameterized.class)
public final class Sha256TwiceTests {
    private final byte[] input;
    private final byte[] expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", "5df6e0e2761359d30a8275058e299fcc0381534545f55cf43e41983f5d4c9456"},
                {"00", "1406e05881e299367766d313e26c05564ec91bf721d31726bd6e46e60689539a"},
                {"01", "9c12cfdc04c74584d787ac3d23772132c18524bc7ab28dec4219b8fc5b425f70"},
                {"0000", "407feb4a4b8303baf4f84e29a209e0dcfd62e81f88c8edb7675c5a95d90e5c90"},
                {"ffff", "fb8d65a41e2f8c97a133f779f5df09b6c5d4ced416f378ef99eea3d86d2b2dfd"},
                {"ab", "a420fdd170370f5d58a7bf3ccbf0689039ec0e6366501bf875fa66837399fcd2"},
                {"cd", "0ff5976bce74d2c3c5265715175a1ba3e4f9e0540201a23016e595599abc9ed4"},
                {"abcd", "179980f6862aedb22205ac97c8af29c77e25d02e189b52926bb1d93796bb3c94"}
        });
    }

    public Sha256TwiceTests(String input, String expected) {
        this.input = toArray(input);
        this.expected = toArray(expected);
    }

    @Test
    public void sha256Test() {
        assertByteArraysSame(expected, sha256Twice(input));
    }
}
