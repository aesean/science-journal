/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.google.android.apps.forscience.whistlepunk.audiogen.voices;

import com.jsyn.Synthesizer;
import com.softsynth.math.AudioMath;

/**
 * Adapt the SimpleJsynUnitVoice to the SimpleJsynAudioGenerator using pentatonic scale.
 * <p>
 * Adapt the SimpleJsynUnitVoice to the SimpleJsynAudioGenerator.
 * This implementation maps the data from the range (min-max) linearly pitches in the pentatonic C
 * major scale covering a wide range of frequencies.
 *
 * </p>
 */
public class DataToPentatonicScalePitchEnvelopeSimpleJsynUnitVoiceAdapter extends
        DataToScalePitchEnvelopeSimpleJsynUnitVoiceAdapter {
    public static final String TAG = "DataToScalePitchEnvelopeSimpleJsynUnitVoiceAdapter";

    private static final int scale[] = {
            0 /* C */, 2 /* D */, 4 /* E */, 7 /* G */, 9 /* A */ }; // pentatonic scale
    // Range of generated frequencies is [FREQ_MIN,FREQ_MAX).  Lower than 200Hz is very quiet on
    // small speakers, while higher than 800Hz tends to sound like a metal detector.
    private static final double FREQ_MIN = 220.;
    private static final double FREQ_MAX = 783.991;
    private static final int PITCH_MIN = (int) Math.floor(AudioMath.frequencyToPitch(FREQ_MIN));
    private static final int PITCH_MAX = (int) Math.floor(AudioMath.frequencyToPitch(FREQ_MAX));

    public DataToPentatonicScalePitchEnvelopeSimpleJsynUnitVoiceAdapter(Synthesizer synth) {
        super(synth, scale, PITCH_MIN, PITCH_MAX);
    }

}
